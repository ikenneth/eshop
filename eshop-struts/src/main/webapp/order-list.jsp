<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="order-list">
    <div class="row">
        <div class="col-md-12">
            <h2>Vos commandes</h2>
            <hr/>
        </div>
    </div>
    <s:if test="hasActionErrors()">
        <div class="row">
            <div class="col-md-12">
                <s:actionerror theme="eshop"/>
            </div>
        </div>
    </s:if>
    <s:if test="#session.user != null && (orders == null || orders.size() == 0)">
        <div class="row cart-empty">
            <div class="col-md-12">
                <h3>Vous n'avez pas de commandes enregistrées</h3>
            </div>
        </div>
    </s:if>
    <s:elseif test="#session.user != null">
        <s:iterator value="orders">
            <div class="row">
                <div class="col-md-12">
                    <table class="table">
                        <thead>
                            <tr>
                                <th colspan="4">
                                    <s:text name="order.title">
                                        <s:param name="value" value="date"/>
                                    </s:text>
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                            <s:iterator value="lines">
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
                                        <s:text name="format.money">
                                            <s:param name="value" value="price"/>
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
                    <strong>Total :&nbsp;
                        <s:text name="format.money">
                            <s:param name="value" value="totalPrice"/>
                        </s:text>
                    </strong>
                </div>
            </div>
        </s:iterator>

    </s:elseif>
</div>