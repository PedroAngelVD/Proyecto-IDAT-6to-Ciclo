import { Component, OnInit } from '@angular/core';
import { ChartDataSets, ChartOptions, ChartType } from 'chart.js';
import { Label, SingleDataSet } from 'ng2-charts';
import * as pluginDataLabels from 'chart.js';
import { ServiceService } from '.././Service/service.service';
import { Datos } from './Modelo/Datos';
import { DatosCAP } from './Modelo/DatosCAP';
import { DatosCAS } from './Modelo/DatosCAS';
import { DatosCMY } from './Modelo/DatosCMY';
import { DatosCRY } from './Modelo/DatosCRY';
import { DatosCMM } from './Modelo/DatosCMM';

import jsPDF from 'jspdf';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})

export class DashboardComponent implements OnInit{

  Imprimir(){
    var id = document.getElementById("circular");
    var pdf = new jsPDF();
    pdf.addImage(id, 'PNG', 10, 10);
    pdf.save("dash");

  }

  datos: Datos[];
  datos2: DatosCAP[];
  datos3: DatosCAS[];
  datos4: DatosCMY[];
  datos5: DatosCRY[];
  datos6: DatosCMM[];

  constructor(private service:ServiceService) { }

  ngOnInit() {
    this.service.getDatos().subscribe(data => {
      this.datos = data;
      var alumM = (data[0].alumM);
      var alumF = (data[0].alumF);
      localStorage.setItem("datoAlumM", alumM.toString());
      localStorage.setItem("datoAlumF", alumF.toString());
      
    });

    this.service.getDatosCAP().subscribe(data => {
      this.datos2 = data;
      var primero = (data[0].primeroPrim);
      var segundo = (data[0].segundoPrim);
      var tercero = (data[0].terceroPrim);
      var cuarto = (data[0].cuartoPrim);
      var quinto = (data[0].quintoPrim);
      var sexto = (data[0].sextoPrim);
      localStorage.setItem("1prim", primero.toString());
      localStorage.setItem("2prim", segundo.toString());
      localStorage.setItem("3prim", tercero.toString());
      localStorage.setItem("4prim", cuarto.toString());
      localStorage.setItem("5prim", quinto.toString());
      localStorage.setItem("6prim", sexto.toString());
    });

    this.service.getDatosCAS().subscribe(data => {
      this.datos3 = data;
      var primero = (data[0].primeroSec);
      var segundo = (data[0].segundoSec);
      var tercero = (data[0].terceroSec);
      var cuarto = (data[0].cuartoSec);
      var quinto = (data[0].quintoSec);
      localStorage.setItem("1sec", primero.toString());
      localStorage.setItem("2sec", segundo.toString());
      localStorage.setItem("3sec", tercero.toString());
      localStorage.setItem("4sec", cuarto.toString());
      localStorage.setItem("5sec", quinto.toString());
    });

    this.service.getDatosCMY().subscribe(data => {
      this.datos4 = data;
      var f2015 = (data[0].f2015M);
      var f2016 = (data[0].f2016M);
      var f2017 = (data[0].f2017M);
      var f2018 = (data[0].f2018M);
      var f2019 = (data[0].f2019M);
      var f2020 = (data[0].f2020M);
      localStorage.setItem("f2015M", f2015.toString());
      localStorage.setItem("f2016M", f2016.toString());
      localStorage.setItem("f2017M", f2017.toString());
      localStorage.setItem("f2018M", f2018.toString());
      localStorage.setItem("f2019M", f2019.toString());
      localStorage.setItem("f2020M", f2020.toString());
    });

    this.service.getDatosCRY().subscribe(data => {
      this.datos5 = data;
      var f2015 = (data[0].f2015R);
      var f2016 = (data[0].f2016R);
      var f2017 = (data[0].f2017R);
      var f2018 = (data[0].f2018R);
      var f2019 = (data[0].f2019R);
      var f2020 = (data[0].f2020R);
      localStorage.setItem("f2015R", f2015.toString());
      localStorage.setItem("f2016R", f2016.toString());
      localStorage.setItem("f2017R", f2017.toString());
      localStorage.setItem("f2018R", f2018.toString());
      localStorage.setItem("f2019R", f2019.toString());
      localStorage.setItem("f2020R", f2020.toString());
    });


    this.service.getDatosCMM().subscribe(data => {
      this.datos6 = data;
      var enero = (data[0].eneroMen);
      var febrero = (data[0].febreroMen);
      var marzo = (data[0].marzoMen);
      var abril = (data[0].abrilMen);
      var mayo = (data[0].mayoMen);
      var junio = (data[0].junioMen);
      var julio = (data[0].julioMen);
      var agosto = (data[0].agostoMen);
      var septiembre = (data[0].septiembreMen);
      var octubre = (data[0].octubreMen);
      var noviembre = (data[0].noviembreMen);
      var diciembre = (data[0].diciembreMen);

      localStorage.setItem("ene", enero.toString());
      localStorage.setItem("feb", febrero.toString());
      localStorage.setItem("mar", marzo.toString());
      localStorage.setItem("abr", abril.toString());
      localStorage.setItem("may", mayo.toString());
      localStorage.setItem("jun", junio.toString());
      localStorage.setItem("jul", julio.toString());
      localStorage.setItem("ago", agosto.toString());
      localStorage.setItem("sep", septiembre.toString());
      localStorage.setItem("oct", octubre.toString());
      localStorage.setItem("nov", noviembre.toString());
      localStorage.setItem("dic", diciembre.toString());
    });

  }

  MetodoGenero(){
    var datoAlumM = localStorage.getItem("datoAlumM");
    var datoAlumF = localStorage.getItem("datoAlumF");
   
    return [+datoAlumM,+datoAlumF];
  }

  MetodoPrimaria(){
    var primero = localStorage.getItem("1prim");
    var segundo = localStorage.getItem("2prim");
    var tercero = localStorage.getItem("3prim");
    var cuarto = localStorage.getItem("4prim");
    var quinto = localStorage.getItem("5prim");
    var sexto = localStorage.getItem("6prim");
    return [+primero,+segundo,+tercero,+cuarto,+quinto,+sexto];
  }

  MetodoSecundaria(){
    var primero = localStorage.getItem("1sec");
    var segundo = localStorage.getItem("2sec");
    var tercero = localStorage.getItem("3sec");
    var cuarto = localStorage.getItem("4sec");
    var quinto = localStorage.getItem("5sec");
    return [+primero,+segundo,+tercero,+cuarto,+quinto];
  }

  MetodoMatriculasYear(){
    var f2015 = localStorage.getItem("f2015M");
    var f2016 = localStorage.getItem("f2016M");
    var f2017 = localStorage.getItem("f2017M");
    var f2018 = localStorage.getItem("f2018M");
    var f2019 = localStorage.getItem("f2019M");
    var f2020 = localStorage.getItem("f2020M");
    return [+f2015,+f2016,+f2017,+f2018,+f2019,+f2020];
  }

  MetodoReinscripcionYear(){
    var f2015 = localStorage.getItem("f2015R");
    var f2016 = localStorage.getItem("f2016R");
    var f2017 = localStorage.getItem("f2017R");
    var f2018 = localStorage.getItem("f2018R");
    var f2019 = localStorage.getItem("f2019R");
    var f2020 = localStorage.getItem("f2020R");
    return [+f2015,+f2016,+f2017,+f2018,+f2019,+f2020];
  }

  MetodoMensualidadMes(){
    var ene = localStorage.getItem("ene");
    var feb = localStorage.getItem("feb");
    var mar = localStorage.getItem("mar");
    var abr = localStorage.getItem("abr");
    var may = localStorage.getItem("may");
    var jun = localStorage.getItem("jun");
    var jul = localStorage.getItem("jul");
    var ago = localStorage.getItem("ago");
    var sep = localStorage.getItem("sep");
    var oct = localStorage.getItem("oct");
    var nov = localStorage.getItem("nov");
    var dic = localStorage.getItem("dic");

    return [+ene, +feb, +mar, +abr, +may, +jun, +jul, +ago, +sep, +oct, +nov, +dic];
  }

  public pieChartOptions: ChartOptions = {
    responsive: true,
    legend: {
      position: 'top',
    },
    plugins: {
      datalabels: {
        formatter: (value, ctx) => {
          const label = ctx.chart.data.labels[ctx.dataIndex];
          return label;
        },
      },
    }
  };
  public pieChartLabels: Label[] = [['Hombres'], ['Mujeres']];
  public pieChartData: number[] = this.MetodoGenero();
  public pieChartType: ChartType = 'pie';
  public pieChartLegend = true;
  public pieChartPlugins = [pluginDataLabels];
  public pieChartColors = [
    {
      backgroundColor: ['#F80202', '#11B700'],
    },
  ];

 //BarChart

  public barChartOptions: ChartOptions = {
    responsive: true,
    scales: { xAxes: [{}], yAxes: [{}] }
  };
  public barChartLabels: Label[] = ['Primero', 'Segundo', 'Tercero', 'Cuarto', 'Quinto', 'Sexto'];
  public barChartType: ChartType = 'bar';
  public barChartLegend = true;

  public barChartData: ChartDataSets[] = [
    { data: this.MetodoPrimaria(), label: 'Primaria', 
    backgroundColor: ['#F80202', '#F80202', '#F80202','#F80202','#F80202','#F80202']},
    { data: this.MetodoSecundaria(), label: 'Secundaria', 
    backgroundColor: ['#004ED6', '#004ED6', '#004ED6','#004ED6','#004ED6'] }
  ];


  // events
  public chartClicked({ event, active }: { event: MouseEvent, active: {}[] }): void {
    console.log(event, active);
  }

  public chartHovered({ event, active }: { event: MouseEvent, active: {}[] }): void {
    console.log(event, active);
  }


  // PolarArea

  public polarAreaChartOptions: ChartOptions = {
    responsive: true,
    legend: {
      position: 'top',
    },
  };

  public polarAreaChartLabels: Label[] = ['2015', '2016', '2017', '2018', '2019', '2020'];
  public polarAreaChartData: SingleDataSet = this.MetodoMatriculasYear()
  public polarAreaLegend = true;
  public polarAreaChartType: ChartType = 'polarArea';

  // Polar2Area

  public polar2AreaChartOptions: ChartOptions = {
    responsive: true,
    legend: {
      position: 'top'
    }
};

  public polar2AreaChartLabels: Label[] = ['2015', '2016', '2017', '2018', '2019', '2020'];
  public polar2AreaChartData: SingleDataSet = this.MetodoReinscripcionYear()
  public polar2AreaLegend = true;
  public polar2AreaChartType: ChartType = 'polarArea';


 //Bar2Chart

 public bar2ChartOptions: ChartOptions = {
  responsive: true,
  scales: { xAxes: [{}], yAxes: [{}] }
};
public bar2ChartLabels: Label[] = ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'];
public bar2ChartType: ChartType = 'horizontalBar';
public bar2ChartLegend = true;

public bar2ChartData: ChartDataSets[] = [
  { data: this.MetodoMensualidadMes(), label: 'Mensualidades Pagadas', 
  backgroundColor: ['#15E800', '#15E800', '#15E800','#15E800','#15E800','#15E800','#15E800', '#15E800', '#15E800','#15E800','#15E800','#15E800']}
];

}

