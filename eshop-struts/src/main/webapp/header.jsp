<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="row">
    <div class="col-md-12">&nbsp;</div>
</div>
<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-10">
        <div class="pull-right">
            <s:if test="#session.user == null">
                <s:a action="login-input">Connexion</s:a>
            </s:if>
            <s:else>
                <s:a action="logout">Déconnexion</s:a>
                |&nbsp;<s:a action="about">Mes commandes</s:a>
            </s:else>
            |&nbsp;<s:a action="about">&Agrave; propos</s:a>
        </div>
    </div>
</div>
<div class="row">
    <div class="col-md-12">&nbsp;</div>
</div>
<div class="row">
    <div class="col-md-3"></div>
    <div class="col-md-4">
        <ul class="nav nav-pills">
            <li class="${productType == 'Product'?'active':''}">
                <s:a action="product-list">
                    Tout
                    <s:param name="productType">Product</s:param>
                </s:a>
            </li>
            <li class="${productType == 'Book'?'active':''}">
                <s:a action="product-list">
                    Livres
                    <s:param name="productType">Book</s:param>
                </s:a>
            </li>
            <li class="${productType == 'Movie'?'active':''}">
                <s:a action="product-list">
                    Films
                    <s:param name="productType">Movie</s:param>
                </s:a>
            </li>
            <li class="${productType == 'Album'?'active':''}">
                <s:a action="product-list">
                    Musique
                    <s:param name="productType">Album</s:param>
                </s:a>
            </li>
        </ul>
    </div>
    <div class="col-md-3">
        <page:applyDecorator name="empty" page="/search.jsp"/>
    </div>
    <div class="col-md-2">
        <s:a action="cart-input">
            <img src="images/basket.png" width="40"/>
        </s:a>
        <s:a action="cart-input">
            Panier
            <s:text name="format.money">
                <s:param name="value" value="#session.cart.totalPrice"/>
            </s:text>
            &nbsp;(<s:property value="#session.cart.totalQuantity"/>)
        </s:a>
        </a>
    </div>
</div>
