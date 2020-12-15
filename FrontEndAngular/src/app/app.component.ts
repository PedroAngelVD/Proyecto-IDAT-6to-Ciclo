import {Component, OnInit} from '@angular/core';
import { Router, Event, NavigationStart, NavigationEnd, NavigationCancel, NavigationError} from '@angular/router';
import { NgxSpinnerService } from "ngx-spinner";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit{
  title = 'FrontEndAngular';

  constructor(private router: Router, private spinner: NgxSpinnerService){

    this.router.events.subscribe((event: Event) => {
      switch (true) {
        case event instanceof NavigationStart: {
          this.spinner.show();
          break;
        }

        case event instanceof NavigationEnd:
        case event instanceof NavigationCancel:
        case event instanceof NavigationError: {
          setTimeout(() => {
            /** spinner ends after 5 seconds */
            this.spinner.hide();
          }, 800);
          break;
        }
        default: {
          break;
        }
      }
    });
  }
  

  ngOnInit() {
    this.router.navigate(['/login'])
    }

  logout(){
    localStorage.removeItem('usuario');
    this.router.navigate(['/login'])
    if(localStorage.getItem('usuario')==null){
      window.location.reload(false);
    }
  }


  

}
