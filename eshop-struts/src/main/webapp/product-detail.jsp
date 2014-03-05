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
                <label>Publication :&nbsp;</label>
                <s:text name="format.date">
                    <s:param name="value" value="product.releaseDate"/>
                </s:text>
            </p>
            <s:if test="product instanceof fr.icodem.eshop.model.Book">
                <div>
                    <p><label>Auteurs :&nbsp;</label>
                        <s:property value="getNames(product.authors)"/>
                    <p><label>ISBN :&nbsp;</label><s:property value="product.isbn"/></p>
                    <p><label>Langue :&nbsp;</label><s:property value="getLanguage(product.language)"/></p>
                    <p><label>Nb pages :&nbsp;</label><s:property value="product.pages"/></p>
                </div>
            </s:if>

            <s:if test="product instanceof fr.icodem.eshop.model.Movie">
            <div ng-if="product.type == 'Movie'">
                <p><label>R&eacute;alisateur :&nbsp;</label>
                   <s:property value="product.director.name"/></p>
                <p><label>Acteurs :&nbsp;</label>
                    <s:property value="getNames(product.actors)"/>
                <p><label>Langues :&nbsp;</label>
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
                <label>Dur&eacute;e :&nbsp;</label><s:property value="product.length"/> min</p>
            </s:if>

            <h3>
                Prix:
                <s:text name="format.money">
                    <s:param name="value" value="product.price"/>
                </s:text>
            </h3>
            <br>

            <s:form cssClass="form-inline" role="form" theme="simple" action="cart-add-item">
                <div class="form-group">
                    <label for="qtyInput" class="control-label">Qt&eacute; :</label>
                    <s:textfield name="quantity" cssClass="form-control" value="1"
                                 theme="simple" type="number" id="qtyInput"/>
                    <s:hidden name="productId" value="%{productId}"/>
                    <s:hidden name="from" value="product-detail"/>
                </div>
                <button class="btn btn-primary" type="submit">
                    <span class="glyphicon glyphicon-shopping-cart"></span> Ajouter
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
                    <a href="#">Description</a>
                </li>
                <li>
                    <a href="#">Commentaires</a>
                </li>
                <li>
                    <a href="#">Produits similaires</a>
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