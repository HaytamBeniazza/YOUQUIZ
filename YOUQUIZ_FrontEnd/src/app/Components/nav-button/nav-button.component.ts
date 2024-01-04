import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-nav-button',
  templateUrl: './nav-button.component.html',
  styleUrls: ['./nav-button.component.css']
})
export class NavButtonComponent {
  @Input() body: string = '';
  @Input() buttonTitle: string = '';
  @Input() route: string = '';

  constructor(private router: Router) {}

  isButtonActive(): boolean {
    return this.router.isActive(this.route, true);
  }

}