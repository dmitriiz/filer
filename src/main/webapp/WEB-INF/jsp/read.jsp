<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ru.dazzled.filer.model.FilerEntity"%>
<%@page import="org.apache.commons.io.IOUtils"%>
<%
    FilerEntity entity = (FilerEntity) request.getAttribute("entity");
    byte[] data = entity.getContent();

    response.setContentType(entity.getMimeType());
    response.setContentLength(data.length);
    response.addHeader("Content-Disposition", "attachment; filename=" + entity.getName());
    IOUtils.write(data, response.getOutputStream());
%>