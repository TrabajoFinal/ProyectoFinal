<#include "base.ftl">

<#macro contenido>


<div class="imagen">
  <img src="/img/liga.png" width="500"/>
</div>
<div role="tabpanel">

  <!-- Nav tabs -->
  <div class="navbar">
    <ul class="nav" role="tablist">
      <li role="presentation"><a href="/freemarker/team" aria-controls="List Users" role="tab" data-toggle="tab"><font color="black">Clasification</font></a></li>
      <li role="presentation" class="active"><a href="/freemarker/team/create" aria-controls="Create User" role="tab" data-toggle="tab"><font color="black">Insertion</font></a></li>
    </ul>
  </div>
  
  <div id="formulario">
  <form>
 
  <div>
    <label for="nombre">Nombre del equipo</label>
    <input type="text" id="nombre" />
  </div>
 
  <div>
    <label for="pj">Partidos Jugados</label>
    <input type="text" id="pj"/>
  </div>
  
  <div>
    <label for="pg">Partidos Ganados</label>
    <input type="text" id="pg"/>
  </div>
  
  <div>
    <label for="pe">Partidos Empatados</label>
    <input type="text" id="pe"/>
  </div>
  
  <div>
    <label for="pp">Partidos Perdidos</label>
    <input type="text" id="pp"/>
  </div>
  
  <div>
    <label for="gf">Goles Favor</label>
    <input type="text" id="gf"/>
  </div>
  
  <div>
    <label for="gc">Goles Contra</label>
    <input type="text" id="gc"/>
  </div>
  
  <div class="col-sm-offset-2 col-sm-10">
	<button type="submit" class="btn btn-primary">Add</button>
	<button type="button" class="btn btn-danger">Reset</button>
  </div>
</form>

</div>


</div>


</#macro>


<@display_page/>   