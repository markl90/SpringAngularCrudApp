import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { AccountService } from '../shared/account/account.service';
import { GiphyService } from '../shared/giphy/giphy.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-account-edit',
  templateUrl: './account-edit.component.html',
  styleUrls: ['./account-edit.component.css']
})
export class AccountEditComponent implements OnInit {

  account: any = {};

  sub: Subscription;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private accountService: AccountService,
              private giphyService: GiphyService) {
  }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      const id = params['id'];
      if (id) {
        this.accountService.get(id).subscribe((account: any) => {
          if (account) {
            this.account = account;
            this.account.href = account._links.self.href;
        //    this.giphyService.get(account.firstName).subscribe(url => account.giphyUrl = url);
          } else {
            console.log(`account with id '${id}' not found, returning to list`);
            this.gotoList();
          }
        });
      }
    });
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

  gotoList() {
    this.router.navigate(['/account-list']);
  }

  save(form: NgForm) {
    this.accountService.save(form).subscribe(result => {
      this.gotoList();
    }, error => console.error(error));
  }

  remove(href) {
    this.accountService.remove(href).subscribe(result => {
      this.gotoList();
    }, error => console.error(error));
  }
}
