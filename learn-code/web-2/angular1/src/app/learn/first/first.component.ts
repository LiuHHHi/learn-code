import { Component, OnInit } from '@angular/core';
import {Title} from "@angular/platform-browser";
import {Router} from "@angular/router";

@Component({
  selector: 'app-first',
  templateUrl: './first.component.html',
  styleUrls: ['./first.component.less']
})
export class FirstComponent implements OnInit {

  firstData: {
    name: string,
    age: number
  } = {
    name: null,
    age: 0
  };

  count = 1000;

  constructor(private title: Title, private router:Router) {
    // 设置浏览器标题
    this.title.setTitle("First页面");
    this.firstData.name = '张3';
    this.firstData.age = 18;
  }

  ngOnInit() {

  }

  ageAddOne() {
    this.firstData.age += 1;
  }

  subCount(count:number) {
    count = count -1;
    console.log(count);
  }

  goSecond() {
    this.router.navigate(['learn','Second'], {
      queryParams: {name: 1, age: 2},
    });
  }

  goSecond2() {
    // 注意第二个页面的参数输出
    this.router.navigateByUrl("learn/Second", {
      queryParams: {name: 1, age: 2},
      // 是否加入浏览器历史
      skipLocationChange: true
    });
  }

  goSecond3() {
    let param = {
      json: "String"
    }
    var s = btoa(encodeURIComponent(JSON.stringify(param)));

    this.router.navigate(['learn','Second2', s], {
      queryParams: {name: 1, age: 2},
      // 是否加入浏览器历史， 注意第二个页面的参数输出
      skipLocationChange: true
    });
  }

  goSecond4() {
    localStorage.setItem("first_to_second_key", "小论文");
    this.router.navigateByUrl("learn/Second");
  }
}
