<#include "base.ftl">

<#macro contenido>


<div class="imagen">
  <img src="/img/liga.png" width="500"/>
</div>
<div role="tabpanel">

  <!-- Nav tabs -->
  <div class="navbar">
    <ul class="nav" role="tablist">
      <li role="presentation" class="active"><a href="/freemarker/team" aria-controls="List Users" role="tab" data-toggle="tab"><font color="black">Clasificación</font></a></li>
      <li role="presentation"><a href="/freemarker/team/create" aria-controls="Create User" role="tab" data-toggle="tab"><font color="black">Inserción</font></a></li>
    </ul>
  </div>

  <!-- Tab panes -->
  <div class="tab-content">

    <div role="tabpanel" class="tab-pane" id="create">
      <form class="form-horizontal">
        <div class="form-group">
          <label for="inputEquipo3" class="col-sm-2 control-label">Equipo</label>
          <div class="col-sm-10">
            <input type="equipo" class="form-control" id="inputEquipo3" placeholder="Nombre del equipo">
          </div>
        </div>
        <div class="form-group">
          <label for="inputPJ3" class="col-sm-2 control-label">P.J.</label>
          <div class="col-sm-10">
            <input type="pj" class="form-control" id="inputPJ3" placeholder="Partidos Jugados">
          </div>
        </div>
        <div class="form-group">
          <label for="inputPG3" class="col-sm-2 control-label">P.G.</label>
          <div class="col-sm-10">
            <input type="pg" class="form-control" id="inputPG3" placeholder="Partidos Ganados">
          </div>
        </div>
        <div class="form-group">
          <label for="inputPE3" class="col-sm-2 control-label">P.E.</label>
          <div class="col-sm-10">
            <input type="pe" class="form-control" id="inputPE3" placeholder="Partidos Empatados">
          </div>
        </div>
        <div class="form-group">
          <label for="inputPP3" class="col-sm-2 control-label">P.P.</label>
          <div class="col-sm-10">
            <input type="pp" class="form-control" id="inputPP3" placeholder="Partidos Perdidos">
          </div>
        </div>
        <div class="form-group">
          <label for="inputGF3" class="col-sm-2 control-label">G.F.</label>
          <div class="col-sm-10">
            <input type="gf" class="form-control" id="inputGF3" placeholder="Goles Favor">
          </div>
        </div>
        <div class="form-group">
          <label for="inputGC3" class="col-sm-2 control-label">G.C.</label>
          <div class="col-sm-10">
            <input type="gc" class="form-control" id="inputGC3" placeholder="Goles Contra">
          </div>
        </div>
        <div class="form-group">
          <label for="inputP3" class="col-sm-2 control-label">Puntos</label>
          <div class="col-sm-10">
            <input type="p" class="form-control" id="inputP3" placeholder="Puntos">
          </div>
        </div>
        <div class="form-group">
          <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-primary">Add</button>
            <button type="button" class="btn btn-danger">Back</button>
          </div>
        </div>
      </form>
    </div>
  </div>

</div>


</#macro>


<@display_page/>   