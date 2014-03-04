<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>

<div class="family-list">
    <ul class="nav">
        <s:iterator value="#session.families" var="family">
            <li>
                <s:a action="product-list" cssClass="%{isFamilyActive(#family)?'active':''}">
                    <s:property value="name"/>
                    <s:param name="familyId"><s:property value="id"/></s:param>
                </s:a>

                <s:if test="subFamilies != null && subFamilies.size() > 0">
                    <ul>
                        <s:iterator value="subFamilies" var="subFamily">
                            <li>
                                <s:a action="product-list" cssClass="%{isFamilyActive(#subFamily)?'active':''}">
                                    <s:property value="name"/>
                                    <s:param name="familyId"><s:property value="id"/></s:param>
                                </s:a>
                            </li>
                        </s:iterator>
                    </ul>
                </s:if>
            </li>
        </s:iterator>
    </ul>
</div>