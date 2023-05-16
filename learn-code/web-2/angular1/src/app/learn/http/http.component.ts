import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {HttpClient, HttpHandler, HttpHeaders, HttpParams, HttpUrlEncodingCodec} from "@angular/common/http";

@Component({
  selector: 'app-http',
  templateUrl: './http.component.html',
  styleUrls: ['./http.component.less']
})
export class HttpComponent implements OnInit {

  constructor(private http: HttpClient) {
  }

  ngOnInit() {
  }

  get1() {
    this.http.get("http://localhost:9001/api/v1/get-1")
      .subscribe(value => {
        console.log(value);
      });
  }

  get2() {
    let httpParams = new HttpParams({
      fromObject: {
        name: '张3',
        age: '18',
        flag: 'true',
        books: '书',
        dept: 'dept'
      },
    });
    console.log(1, httpParams.toString());
    // 注意参数的变化看看有啥不一样
    httpParams = httpParams.append('books', 'a');
    console.log(2, httpParams.toString());
    // 注意参数的变化看看有啥不一样
    httpParams = httpParams.set('books', 'b');
    console.log(3, httpParams.toString());
    this.http.get("http://localhost:9001/api/v1/get-2", {
      params: httpParams
    }).subscribe(value => {
      console.log(value);
    });
  }

  get3() {
    let name = '张3';
    let age = 18;
    let url = 'http://localhost:9001/api/v1/get-3/' + name + '/' + age;
    this.http.get(url).subscribe(value => {
      console.log(value);
    });
  }

  post1() {
    this.http.post('http://localhost:9001/api/v1/post-1/form', {}, {
      params: new HttpParams({
        fromString: 'name=张3&age=18'
      })
    }).subscribe(value => {
      console.log(value);
    });
  }

  post1_1() {
    this.http.post('http://localhost:9001/api/v1/post-1/form', {}, {
      params: new HttpParams({
        fromObject: {
          name: '张3',
          age: '18'
        }
      })
    }).subscribe(value => {
      console.log(value);
    });
  }

  post1_2() {
    let formData = new FormData();
    formData.append('name', '张3');
    formData.append('age', '18');
    this.http.post('http://localhost:9001/api/v1/post-1/form', formData).subscribe(value => {
      console.log(value);
    });
  }

  post2() {
    let params = new HttpParams({
      fromObject: {
        name: '张3',
        age: '18'
      }
    });
    this.http.post(
      'http://localhost:9001/api/v1/post-2/x-www-form-urlencoded',
      params
    ).subscribe(value => {
      console.log(value);
    });
  }

  post3() {
    this.http.post(
      'http://localhost:9001/api/v1/post-3/json',
      {
        name: '张3',
        age: '18'
      }
    ).subscribe(value => {
      console.log(value);
    });
  }

  files: File[] = [];
  fileUploadChange(e) {
    console.log(e.target.files);
    this.files = e.target.files;
  }

  postFile() {
    if (!this.files || this.files.length === 0) {
      alert("请选择文件");
      return;
    }
    let formData = new FormData();
    formData.append('uploadFile', this.files[0]);
    this.http.post('http://localhost:9001/api/v1/post-file', formData).subscribe(value => {
      console.log(value);
    });
  }

}
