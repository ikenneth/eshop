<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>


<div class="product-detail">
    <div class="row">
        <div class="col-md-12">
            <h2><s:property value="product.name"/></h2>
            <hr/>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4">
            <s:if test="product.image != null">
                <s:url action="product-image" var="productImage">
                    <s:param name="imageId"><s:property value="product.image.id"/></s:param>
                </s:url>
            </s:if>
            <s:else>
                <s:url value="images/no-image.png" var="productImage"/>
            </s:else>
            <s:set value="productImage" var="productImage" scope="page"/>
            <img src="${productImage}" style="max-width: 320px;max-height: 320px;" />
        </div>
        <div class="col-md-8">
            <p>
                <label><s:text name="release-date"/> :&nbsp;</label>
                <s:text name="format.date">
                    <s:param name="value" value="product.releaseDate"/>
                </s:text>
            </p>
            <s:if test="product instanceof fr.icodem.eshop.model.Book">
                <div>
                    <p><label><s:text name="actors"/> :&nbsp;</label>
                        <s:property value="getNames(product.authors)"/>
                    <p><label><s:text name="isbn"/> :&nbsp;</label><s:property value="product.isbn"/></p>
                    <p><label><s:text name="language"/> :&nbsp;</label><s:property value="getLanguage(product.language)"/></p>
                    <p><label><s:text name="nb-pages"/> :&nbsp;</label><s:property value="product.pages"/></p>
                </div>
            </s:if>

            <s:if test="product instanceof fr.icodem.eshop.model.Movie">
            <div ng-if="product.type == 'Movie'">
                <p><label><s:text name="director"/> :&nbsp;</label>
                   <s:property value="product.director.name"/></p>
                <p><label><s:text name="actors"/> :&nbsp;</label>
                    <s:property value="getNames(product.actors)"/>
                <p><label><s:text name="languages"/> :&nbsp;</label>
                    <s:property value="getLanguages(product.languages)"/>
                </p>
            </div>
            </s:if>

            <s:if test="product instanceof fr.icodem.eshop.model.Album">
                <p ng-if="product.type == 'Album'"><label>Artistes : </label>
                    <s:property value="getNames(product.artists)"/>
            </s:if>

            <s:if test="product instanceof fr.icodem.eshop.model.Movie || product instanceof fr.icodem.eshop.model.Album">
                <p ng-if="product.type == 'Movie' || product.type == 'Album'">
                <label><s:text name="duration"/> :&nbsp;</label><s:property value="product.length"/> min</p>
            </s:if>

            <h3>
                <s:text name="price"/>&nbsp;:
                <s:text name="format.money">
                    <s:param name="value" value="product.price"/>
                </s:text>
            </h3>
            <br>

            <s:form cssClass="form-inline" role="form" theme="simple" action="cart-add-item">
                <div class="form-group">
                    <label for="qtyInput" class="control-label"><s:text name="quantity"/>&nbsp;:</label>
                    <s:textfield name="quantity" cssClass="form-control" value="1"
                                 theme="simple" type="number" id="qtyInput"/>
                    <s:hidden name="productId" value="%{productId}"/>
                    <s:hidden name="from" value="product-detail"/>
                </div>
                <button class="btn btn-primary" type="submit">
                    <span class="glyphicon glyphicon-shopping-cart"></span> <s:text name="add"/>
                </button>
            </s:form>


        </div>
    </div>

    <div class="row">
        <div class="col-md-12">
            <div rating/>
        </div>
    </div>

    <hr/>

    <div class="row">
        <div class="col-md-12">
            <ul class="nav nav-tabs">
                <li class="active">
                    <a href="#"><s:text name="description"/></a>
                </li>
                <li>
                    <a href="#"><s:text name="comments"/></a>
                </li>
                <li>
                    <a href="#"><s:text name="similar-products"/></a>
                </li>
            </ul>
            <div class="tab-content">
                <div class="tab-pane active">
                    <p><s:property value="product.description"/></p>
                </div>
                <div class="tab-pane">
                    <p>Commentaires...</p>
                </div>
                <div class="tab-pane">
                    <p>Les produits similaires...</p>
                </div>
            </div>
        </div>
    </div>
</div>