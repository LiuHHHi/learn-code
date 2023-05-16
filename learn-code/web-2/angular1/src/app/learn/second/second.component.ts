import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-second',
  templateUrl: './second.component.html',
  styleUrls: ['./second.component.less']
})
export class SecondComponent implements OnInit {

  constructor(private activatedRoute: ActivatedRoute) {
    let queryParams = this.activatedRoute.snapshot.queryParams;
    let params = this.activatedRoute.snapshot.params;
    let paramString: string = params['object'];
    if (paramString) {
      let param = decodeURIComponent(atob(paramString));
      console.log(param);
    }
    console.log(queryParams, params, paramString);
    let item = localStorage.getItem("first_to_second_key");
    // localStorage.removeItem("first_to_second_key");
    console.log(item);
  }

  ngOnInit() {
  }

}
