<#if (actionErrors?? && actionErrors?size > 0)>
    <div class="alert alert-danger text-center alert-dismissable">
	<#list actionErrors as error>
		<#if error?if_exists != "">
            <#if parameters.escape>${error!?html}<#else>${error!}</#if>
        </#if>
	</#list>
	</div>
</#if>