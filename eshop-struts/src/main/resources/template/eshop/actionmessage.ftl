<#if (actionMessages?? && actionMessages?size > 0 && !parameters.isEmptyList)>
    <div class="text-center alert alert-info alert-dismissable">
		<#list actionMessages as message>
            <#if message?if_exists != "">
                <#if parameters.escape>${message!?html}<#else>${message!}</#if>
            </#if>
		</#list>
	</div>
</#if>