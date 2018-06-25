import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  public API = '//localhost:8080';
  public ACCOUNT_API = this.API + '/accounts';
  public ADD_ACCOUNT_API = this.API + '/add-accounts';

  constructor(private http: HttpClient) {
    }

    getAll(): Observable<any> {
      return this.http.get('//localhost:8080/accounts');
    }

    get(id: string) {
    return this.http.get(this.ACCOUNT_API + '/' + id);
  }

  save(account: any): Observable<any> {
    let result: Observable<Object>;
    if (account['href']) {
      result = this.http.put(account.href, account);
    } else {
      var accountJSON = JSON.stringify(account);
      console.log(account);
      result = this.http.post(this.ADD_ACCOUNT_API, accountJSON);
    }
    return result;
  }

  remove(href: string) {
    return this.http.delete(href);
  }
}
