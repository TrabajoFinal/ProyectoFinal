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
	  
	  <div id="posiciones">
		<table class="puestos">
			<tr>
				<th bgcolor="#8BFB65">Champions League</th>
				<th bgcolor="#F78D4C">Europa League</th>
				<th bgcolor="#F72C2C">Descenso</th>
			</tr>
		</table>
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
				  <#if (team_index <= 3)>
				   <td bgcolor="#8BFB65" width="8">${team_index + 1}</td>
				   </#if>
				   <#if (team_index == 4 || team_index == 5)>
				   <td bgcolor="#F78D4C">${team_index + 1}</td>
				   </#if>
				   <#if (team_index > 5 && team_index < 17)>
				   <td>${team_index + 1}</td>
				   </#if>
				   <#if (team_index >= 17)>
				   <td bgcolor="#F72C2C">${team_index + 1}</td>
				   </#if>
				   <td>${team.nombre}</td>
				   <td>${team.pj}</td>
				   <td>${team.pg}</td>
				   <td>${team.pe}</td>
				   <td>${team.pp}</td>
				   <td>${team.gf}</td>
				   <td>${team.gc}</td>
				   <td>${team.puntos}</td>
				   <td>
					<a href="/update/${team.id}"><span class="glyphicon glyphicon-edit"></span>Edit</a>
					<a href="/delete/${team.id}"><span class="glyphicon glyphicon-trash"></span>Delete</a>
				  </td>
				</tr>
				</#list>
			  </tbody>
			</div>
		  </table>
		</div>

	  </div>
	</div>

	</div>


	</#macro>


	<@display_page/>   