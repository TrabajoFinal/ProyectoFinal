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
 
            <li><a href="/"><font color="black">Clasification</font></a></li>
            <li class="active"><a href="/create"><font color="black">Insertion</font></a></li>
 
                    </ul>
    </div>
</div>
  
  <div id="formulario">
  <form name="team" action="/create" method="post">
 
  <div>
    <label for="nombre">Nombre del equipo</label>
    <input type="text" name="nombre" />
  </div>
 
  <div>
    <label for="pj">Partidos Jugados</label>
    <input type="text" name="pj"/>
  </div>
  
  <div>
    <label for="pg">Partidos Ganados</label>
    <input type="text" name="pg"/>
  </div>
  
  <div>
    <label for="pe">Partidos Empatados</label>
    <input type="text" name="pe"/>
  </div>
  
  <div>
    <label for="pp">Partidos Perdidos</label>
    <input type="text" name="pp"/>
  </div>
  
  <div>
    <label for="gf">Goles Favor</label>
    <input type="text" name="gf"/>
  </div>
  
  <div>
    <label for="gc">Goles Contra</label>
    <input type="text" name="gc"/>
  </div>

  <div>
    <label for="puntos">Puntos</label>
    <input type="text" name="puntos"/>
  </div>
  
  <div class="col-sm-offset-2 col-sm-10">
	<button type="submit" class="btn btn-primary">Add</button>
	<button type="button" class="btn btn-danger" action="/create">Reset</button>
  </div>
</form>

</div>


</div>


</#macro>


<@display_page/>   