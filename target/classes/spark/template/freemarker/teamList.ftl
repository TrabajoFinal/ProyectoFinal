<#include "base.ftl">
<#macro contenido>
<div class="imagen">
  <img src="/img/liga.png" width="500"/>
</div>

<table class="datatable">
    <tr>
      <th>Equipo</th>  
      <th>Partidos Jugados</th>
      <th>Partidos Ganados</th>
      <th>Partidos Empatados</th>
      <th>Partidos Perdidos</th>
      <th>Goles Favor</th>
      <th>Goles Contra</th>
      <th>Puntos</th>
      <th>Action</th>
    </tr>
  <#list teams as team>
    <tr>
     <td>${team.nombre}</td> 
     <td>${team.pj}</td>
     <td>${team.pg}</td>
     <td>${team.pe}</td>
     <td>${team.pp}</td>
     <td>${team.gf}</td>
     <td>${team.gc}</td>
     <td>${team.puntos}</td>
     <td>
        <a href=""><span class="glyphicon glyphicon-edit"></span> Edit</a>
        <a href=""><span class="glyphicon glyphicon-trash"></span> Delete</a>
     </td>
    </tr>
  </#list>
</table>
</#macro>

<@display_page />