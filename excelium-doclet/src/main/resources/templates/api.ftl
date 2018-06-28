# <#if isWeb>Web<#else>Mobile</#if> API

## Command Table

Command | Method | Param 1 | Param 2 | Param 3
--------- | --------- | --------- | --------- | ---------
<#list items>
<#items as command>
${command.getName()} | ${command.getMethod()} | ${(command.getParam1())!} | ${(command.getParam2())!} | ${(command.getParam3())!}
</#items>
</#list>

<#list details>
<#items as command>
## ${command.getName()}

${(command.getDescription())!}

### Usage

<#list command.getUsages()>
<#items as usage>
`
${usage}
`

</#items>
</#list>
<#if (command.getParameterTags())??>
### Parameters

Parameter | Description
--------- | -----------
<#list command.getParameterTags()>
<#items as param>
${param.getName()} | ${(param.getComment())!}
</#items>
</#list>
</#if>

</#items>
</#list>