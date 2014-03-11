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
                <s:a action="login-input"><s:text name="login"/></s:a>
            </s:if>
            <s:else>
                <s:a action="logout"><s:text name="logout"/></s:a>
                |&nbsp;<s:a action="order-list"><s:text name="my-orders"/></s:a>
            </s:else>
            |&nbsp;<s:a action="about"><s:text name="about"/></s:a>
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
                    <s:text name="all"/>
                    <s:param name="productType">Product</s:param>
                </s:a>
            </li>
            <li class="${productType == 'Book'?'active':''}">
                <s:a action="product-list">
                    <s:text name="book"/>
                    <s:param name="productType">Book</s:param>
                </s:a>
            </li>
            <li class="${productType == 'Movie'?'active':''}">
                <s:a action="product-list">
                    <s:text name="movie"/>
                    <s:param name="productType">Movie</s:param>
                </s:a>
            </li>
            <li class="${productType == 'Album'?'active':''}">
                <s:a action="product-list">
                    <s:text name="album"/>
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
            <s:text name="cart"/>
            <s:text name="format.money">
                <s:param name="value" value="#session.cart.totalPrice"/>
            </s:text>
            &nbsp;(<s:property value="#session.cart.totalQuantity"/>)
        </s:a>
        </a>
    </div>
</div>
