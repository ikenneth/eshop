<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="shopping-cart">
    <div class="row">
        <div class="col-md-12">
            <h2><s:text name="cart.label"/></h2>
            <hr/>
        </div>
    </div>
    <s:if test="cart.isEmpty()">
        <div class="row cart-empty">
            <div class="col-md-12">
                <h3><s:text name="cart.empty"/></h3>
            </div>
        </div>
    </s:if>
    <s:else>
        <s:if test="hasActionMessages()">
            <div class="row">
                <div class="col-md-12">
                    <s:actionmessage theme="eshop"/>
                </div>
            </div>
        </s:if>
        <s:if test="hasActionErrors()">
            <div class="row">
                <div class="col-md-12">
                    <s:actionerror theme="eshop"/>
                </div>
            </div>
        </s:if>
        <div class="row">
            <div class="col-md-12">
                <table class="table">
                    <thead>
                        <tr>
                            <th colspan="2"><s:text name="product.label"/></th>
                            <th colspan="3"><s:text name="product.quantity"/></th>
                        </tr>
                    </thead>
                    <tbody>
                        <s:iterator value="cart.items">
                            <tr>
                                <td>
                                    <s:if test="product.image != null">
                                        <s:url action="product-image" var="productImage">
                                            <s:param name="imageId"><s:property value="product.image.id"/></s:param>
                                        </s:url>
                                    </s:if>
                                    <s:else>
                                        <s:url value="images/no-image.png" var="productImage"/>
                                    </s:else>
                                    <s:set value="productImage" var="productImage" scope="page"/>
                                    <img src="${productImage}" width="40px" />
                                </td>
                                <td>
                                    <s:a action="product-detail">
                                        <s:property value="product.name"/>
                                        <s:param name="productId"><s:property value="product.id"/></s:param>
                                    </s:a>
                                </td>
                                <td><s:property value="quantity"/></td>
                                <td>
                                    <s:a action="cart-remove-item" cssClass="btn btn-danger">
                                        <span class="glyphicon glyphicon-trash"></span> <s:text name="remove"/>
                                        <s:param name="productId"><s:property value="product.id"/></s:param>
                                    </s:a>
                                </td>
                                <td>
                                    <s:text name="format.money">
                                        <s:param name="value" value="totalPrice"/>
                                    </s:text>
                                </td>
                            </tr>
                        </s:iterator>
                    </tbody>
                </table>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12">
                <strong><s:text name="total-price"/> :&nbsp;
                    <s:text name="format.money">
                        <s:param name="value" value="cart.totalPrice"/>
                    </s:text>
                </strong>
            </div>
        </div>
        <s:if test="!cart.checkedOut">
            <div class="row">
                <div class="col-md-12">
                    <s:if test="#session.user != null">
                        <s:a action="checkout" cssClass="btn btn-success">
                            <span class="glyphicon glyphicon-check"></span> <s:text name="order.checkout"/>
                        </s:a>
                    </s:if>
                    <s:elseif test="!cart.checkedOut">
                        <a class="btn btn-success" disabled>
                            <span class="glyphicon glyphicon-check"></span> <s:text name="order.checkout"/>
                        </a>
                    </s:elseif>
                </div>
            </div>
        </s:if>
    </s:else>
</div>