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
                <th scope="col">Pos</th>
                <th scope="col">Equipo</th>
                <th scope="col">P.J.</th>
                <th scope="col">P.G.</th>
                <th scope="col">P.E.</th>
                <th scope="col">P.P.</th>
                <th scope="col">G.F.</th>
                <th scope="col">G.C.</th>
                <th scope="col">Puntos</th>
                <th scope="col">Action</th>
              </tr>
            </thead>
          </div>

          <div id="cuerpo">
            <tbody>
              <tr>
                <td>1</td>
                <td>Barcelona</td>
                <td>36</td>
                <td>29</td>
                <td>3</td>
                <td>4</td>
                <td>107</td>
                <td>19</td>
                <td>90</td>         
                <td>
                  <a href=""><span class="glyphicon glyphicon-edit"></span> Edit</a>
                  <a href=""><span class="glyphicon glyphicon-trash"></span> Delete</a>
                </td>
              </tr>
              <tr>
                <td>2</td>
                <td>R. Madrid</td>
                <td>36</td>
                <td>28</td>
                <td>2</td>
                <td>6</td>
                <td>107</td>
                <td>34</td>
                <td>86</td>         
                <td>
                  <a href=""><span class="glyphicon glyphicon-edit"></span> Edit</a>
                  <a href=""><span class="glyphicon glyphicon-trash"></span> Delete</a>
                </td>
              </tr>
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