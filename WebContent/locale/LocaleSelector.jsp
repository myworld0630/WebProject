<%@taglib prefix="s" uri="/struts-tags"%>

<script type="text/javascript">
    function langSelecter_onChanged() {
        document.langForm.submit();
    }
</script>

<s:set name="SESSION_LOCALE" value="#session['WW_TRANS_I18N_LOCALE']"/>
<s:bean id="locales" name="web.struts.multilanguage.Locales"/>

<form action="<s:url includeParams="get" encode="true"/>" name="langForm" 
    style="background-color: powderblue; padding-top: 4px; padding-bottom: 4px;">
    Language: <s:select label="Language" 
        list="#locales.locales" listKey="value"    listValue="key"
        value="#SESSION_LOCALE == null ? locale : #SESSION_LOCALE"
        name="request_locale" id="langSelecter" 
        onchange="langSelecter_onChanged()" theme="simple"/>
</form>