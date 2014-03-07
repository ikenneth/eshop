<#if (actionMessages?? && actionMessages?size > 0 && !parameters.isEmptyList)>
    <p class="text-center alert alert-info">
		<#list actionMessages as message>
            <#if message?if_exists != "">
                <#if parameters.escape>${message!?html}<#else>${message!}</#if>
            </#if>
		</#list>
	</p>
</#if>