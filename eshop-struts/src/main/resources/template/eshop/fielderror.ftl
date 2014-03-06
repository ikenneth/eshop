<#if fieldErrors??><#t/>
    <#assign eKeys = fieldErrors.keySet()><#t/>
    <#assign eKeysSize = eKeys.size()><#t/>
    <#assign doneStartUlTag=false><#t/>
    <#assign doneEndUlTag=false><#t/>
    <#assign haveMatchedErrorField=false><#t/>
    <#if (fieldErrorFieldNames?size > 0) ><#t/>
        <#list fieldErrorFieldNames as fieldErrorFieldName><#t/>
            <#list eKeys as eKey><#t/>
                <#if (eKey = fieldErrorFieldName)><#t/>
                    <#assign haveMatchedErrorField=true><#t/>
                    <#assign eValue = fieldErrors[fieldErrorFieldName]><#t/>
                    <#list eValue as eEachValue><#t/>
                        <span class="help-block field-error">
                            <span class="glyphicon glyphicon-warning-sign"></span>
                            <#if parameters.escape>${eEachValue!?html}<#else>${eEachValue!}</#if>
                        </span>
                    </#list><#t/>
                </#if><#t/>
            </#list><#t/>
        </#list><#t/>
    <#t/>
    <#else><#t/>
        <#if (eKeysSize > 0)><#t/>
            <#list eKeys as eKey><#t/>
                <#assign eValue = fieldErrors[eKey]><#t/>
                <#list eValue as eEachValue><#t/>
                    <span class="help-block field-error">
                        <span class="glyphicon glyphicon-warning-sign"></span>
                        <#if parameters.escape>${eEachValue!?html}<#else>${eEachValue!}</#if>
                    </span>
                </#list><#t/>
            </#list><#t/>
        </#if><#t/>
    </#if><#t/>
</#if><#t/>
