<%@ include file="/html/portlet/document_library/init.jsp" %>


<%
    Folder folder = (Folder)request.getAttribute("folder_action::folder");
%>
						<liferay-ui:icon
							image="add_folder"
							message='<%= "Option 1" %>'
							url='http://www.permeance.com.au/'
							target="_blank"
						/>