<#include "base.ftl">

<#macro contenido>


<div class="imagen">
  <img src="/img/liga.png" width="500"/>
</div>
<div role="tabpanel">

  <!-- Nav tabs -->
<div class="navbar">
    <div class="navbar-inner">
        <ul class="nav">
 
            <li class="active"><a href="/"><font color="black">Clasification</font></a></li>
            <li><a href="/create"><font color="black">Insertion</font></a></li>
 
                    </ul>
    </div>
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
                <th>Pos</th>
                <th>Equipo</th>  
                <th>P.J.</th>
                <th>P.G.</th>
                <th>P.E.</th>
                <th>P.P.</th>
                <th>G.F.</th>
                <th>G.C.</th>
                <th>Puntos</th>
                <th>Action</th>
              </tr>
            </thead>
          </div>

          <div id="cuerpo">
          <tbody>
            <#list teams as team>
                <tr>
                 <td>${team_index + 1}</td>
                 <td>${team.nombre}</td> 
                 <td>${team.pj}</td>
                 <td>${team.pg}</td>
                 <td>${team.pe}</td>
                 <td>${team.pp}</td>
                 <td>${team.gf}</td>
                 <td>${team.gc}</td>
                 <td>${team.puntos}</td>
                 <td>
                    <a href="/edit/${team_index}"><span class="glyphicon glyphicon-edit"></span>Edit</a>
                    <a href="/delete/${team_index}"><span class="glyphicon glyphicon-trash"></span>Delete</a>
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