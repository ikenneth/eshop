eshopModule = angular.module('eshop', ['ngResource', 'ngRoute'])
                     .config(function($routeProvider) {
        $routeProvider.
            when('/product/list', {templateUrl: 'product-list.html'}).
            when('/product/:productId', {
                templateUrl: 'product-detail.html',
                controller: 'ProductDetailCtrl',
                resolve: {
                    product: function($route, ProductResource) {
                        return ProductResource.get({productId:$route.current.params.productId});
                    }
                }
            }).
            when('/cart', {templateUrl: 'cart.html'}).
            when('/about', {templateUrl: 'about.html'}).
            when('/login', {
                templateUrl: 'login.html',
                controller: 'LoginCtrl'
            }).
            when('/register', {templateUrl: 'register.html'}).
            when('/account', {
                templateUrl: 'account.html',
                controller: 'AccountCtrl'
            }).
            otherwise({redirectTo: '/product/list'});
    });

eshopModule.controller('FamilyListCtrl', function($scope, familyService) {
    $scope.familyService = familyService;

    familyService.loadFamilies();

});

eshopModule.controller('ProductSearchCtrl', function($scope, productService) {
    $scope.service = productService;
    $scope.keyword = "";

});

eshopModule.controller('ProductListCtrl', function($scope, productService) {
    $scope.service = productService;

});

eshopModule.controller('ProductDetailCtrl', function($scope, product, languageService) {
    $scope.product = product;
    $scope.getLanguage = function(code) {
        return languageService.getLabel(code);
    };
});

eshopModule.controller('LoginCtrl', function($scope, accountService) {
    $scope.service = accountService;
});

eshopModule.controller('AccountCtrl', function($scope, accountService) {
    $scope.service = accountService;
    console.log(accountService);
});



eshopModule.factory('ProductFamilyResource', function($resource) {
    return $resource('rest/family');
});

eshopModule.factory('ProductResource', function($resource) {
    return $resource('rest/product/:productId', {productId:"@productId"});
});

eshopModule.factory('AccountResource', function($resource) {
    return $resource('rest/account');
});

eshopModule.factory('familyService', function(ProductFamilyResource, productService) {
    return {
        families: null,
        selectedFamily: null,
        selectedSubFamily: null,
        loadFamilies: function() {
            this.families = ProductFamilyResource.query();
        },
        selectFamily : function(family) {
            this.selectedFamily = family;
            this.selectedSubFamily = null;
            productService.searchByFamily(family.id);
        },
        selectSubFamily : function(subFamily) {
            this.selectedSubFamily = subFamily;
            productService.searchByFamily(subFamily.id);
        },
        isFamilySelected : function(family) {
            return this.selectedFamily == family
        },
        isSubFamilySelected : function(subFamily) {
            return this.selectedSubFamily == subFamily;
        }
    };
});

eshopModule.factory('productService', function(ProductResource, $location) {
    return {
        products: null,
        searchByKeyword: function(keyword) {
            this.products = ProductResource.query({keyword: keyword});
            $location.path('/product-list');
        },
        searchByFamily: function(familyId) {
            this.products = ProductResource.query({familyId: familyId});
            $location.path('/product-list');
        }
    };
});

eshopModule.factory('languageService', function() {
    return {
        getLabel: function(code) {
            switch (code) {
                case 'fr':
                    return 'Fran\u00E7ais';
                case 'en':
                    return 'Anglais';
                default :
                    return code;
            }
        }
    };
});

eshopModule.factory('accountService', function(Base64, $http, AccountResource, $location) {
    return {
        userDetail: null,
        login: function(username, password) {

            var encodedUserNameAndPassword = Base64.encode(username + ':' + password);
            $http.defaults.headers.common['Authorization'] = 'Basic ' + encodedUserNameAndPassword;

            var self = this;
            AccountResource.get(
                function(data) {// success handler
                    self.userDetail = data;
                    console.log(data.firstName);
                    $location.path('/account');
                }, function(error) {// error handler
                    alert('erreur authentification');
                });

            /*
             Resource.query().$promise.then(function(data) {
             // success handler
             }, function(error) {
             // error handler
             });
             */

        },
        logout: function() {
            this.userDetail = null;
            document.execCommand("ClearAuthenticationCache");
            delete $http.defaults.headers.common.Authorization;
            // $http.defaults.headers.common.Authorization = 'Basic ';
            // $templateCache TODO remove template from cache
        }
    };
});


eshopModule.factory('Base64', function() {
    var keyStr = 'ABCDEFGHIJKLMNOP' +
        'QRSTUVWXYZabcdef' +
        'ghijklmnopqrstuv' +
        'wxyz0123456789+/' +
        '=';
    return {
        encode: function (input) {
            var output = "";
            var chr1, chr2, chr3 = "";
            var enc1, enc2, enc3, enc4 = "";
            var i = 0;

            do {
                chr1 = input.charCodeAt(i++);
                chr2 = input.charCodeAt(i++);
                chr3 = input.charCodeAt(i++);

                enc1 = chr1 >> 2;
                enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
                enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
                enc4 = chr3 & 63;

                if (isNaN(chr2)) {
                    enc3 = enc4 = 64;
                } else if (isNaN(chr3)) {
                    enc4 = 64;
                }

                output = output +
                    keyStr.charAt(enc1) +
                    keyStr.charAt(enc2) +
                    keyStr.charAt(enc3) +
                    keyStr.charAt(enc4);
                chr1 = chr2 = chr3 = "";
                enc1 = enc2 = enc3 = enc4 = "";
            } while (i < input.length);

            return output;
        },

        decode: function (input) {
            var output = "";
            var chr1, chr2, chr3 = "";
            var enc1, enc2, enc3, enc4 = "";
            var i = 0;

            // remove all characters that are not A-Z, a-z, 0-9, +, /, or =
            var base64test = /[^A-Za-z0-9\+\/\=]/g;
            if (base64test.exec(input)) {
                alert("There were invalid base64 characters in the input text.\n" +
                    "Valid base64 characters are A-Z, a-z, 0-9, '+', '/',and '='\n" +
                    "Expect errors in decoding.");
            }
            input = input.replace(/[^A-Za-z0-9\+\/\=]/g, "");

            do {
                enc1 = keyStr.indexOf(input.charAt(i++));
                enc2 = keyStr.indexOf(input.charAt(i++));
                enc3 = keyStr.indexOf(input.charAt(i++));
                enc4 = keyStr.indexOf(input.charAt(i++));

                chr1 = (enc1 << 2) | (enc2 >> 4);
                chr2 = ((enc2 & 15) << 4) | (enc3 >> 2);
                chr3 = ((enc3 & 3) << 6) | enc4;

                output = output + String.fromCharCode(chr1);

                if (enc3 != 64) {
                    output = output + String.fromCharCode(chr2);
                }
                if (enc4 != 64) {
                    output = output + String.fromCharCode(chr3);
                }

                chr1 = chr2 = chr3 = "";
                enc1 = enc2 = enc3 = enc4 = "";

            } while (i < input.length);

            return output;
        }
    };
});


eshopModule.directive('rating', function() {
    return {
        templateUrl: 'rating.html'
    }
});
