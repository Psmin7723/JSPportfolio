<%@ page contentType="text/html;charset=euc-kr" %>

<HTML>
<HEAD>
   <TITLE>���Ͼ��ε�</TITLE>
</HEAD>

<BODY>
<div align="center">
<H1> �������� ���ε� �׽�Ʈ</H1><br>

<FORM action="upload.jsp" enctype="multipart/form-data" method="post">
<TABLE align=center border=0>
   <TR><td>�ۼ���</td>
       <td><input type="text" name="name"  size=20></td></TR>
   <TR><td>���ϸ�</td>
       <td><input type="file" name="file1" size=20><br>
           <input type="file" name="file2" size=20></td></TR>
   <TR><td colspan=2 align=center>
           <input type="submit" value=" �������� ">
       </td></TR>  
</TABLE>
</FORM>
</BODY>
</HTML>