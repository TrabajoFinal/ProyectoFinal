<#include "base.ftl">

<#macro contenido>


<div class="imagen">
  <img src="/img/liga.png" width="500"/>
</div>
<div role="tabpanel">

  <!-- Nav tabs -->
  <div class="navbar">
    <ul class="nav" role="tablist">
      <li role="presentation" class="active"><a href="/freemarker/team" aria-controls="List Users" role="tab" data-toggle="tab"><font color="black">Clasification</font></a></li>
      <li role="presentation"><a href="/freemarker/team/create" aria-controls="Create User" role="tab" data-toggle="tab"><font color="black">Insertion</font></a></li>
    </ul>
  </div>

  <!-- Tab panes -->
  <div class="tab-content">
    <div role="tabpanel" class="tab-pane active" id="list">
      <br>
      <div class="table-responsive">
        <table class="table table-hover">
          <div id="cabecera">
            <thead>
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
            </thead>
          </div>

          <div id="cuerpo">
          <tbody>
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
            </tbody>
          </div>
        </table>
      </div>

      <nav>
        <ul class="pager">
          <li><a href="#">Previous</a></li>
          <li><a href="#">Next</a></li>
        </ul>
      </nav>
      
    </div>
  </div>

</div>


</#macro>


<@display_page/>   