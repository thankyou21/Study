import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Rishav';
  source="../assets/Capgemini.jpg";
  height=200;
  width=400;
  
  srcArr=["Capgemini","CapgeminiLogo"];
  i=0;
  changeImage():void
  {
  		if(this.i==this.srcArr.length) 
  			this.i=0;
  		this.source="../assets/"+this.srcArr[this.i++]+".jpg";
  }
}
