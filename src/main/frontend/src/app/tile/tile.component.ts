import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-tile',
  templateUrl: './tile.component.html',
  styleUrls: ['./tile.component.css']
})
export class TileComponent implements OnInit {
  result2: any;
  result: any;
  posts: any;
  title: any;
  url: any;
  url1: any;
  constructor(private http: HttpClient) {
   this.title = "tile title1";
   this.url = 'http://localhost:8080/game';
    this.url1 = 'src/app/tile/ex.json';

   console.log(this.url);
   this.result = http.get(this.url);
   console.log("result1 " + this.result);
   this.result2 = http.get(this.url);
   console.log("result2 " + this.result2);
  }
getResult() {
        this.posts = this.http.get(this.url +'/posts');
        this.result = this.http.get(this.url);
     }
  ngOnInit() {
  }


}
