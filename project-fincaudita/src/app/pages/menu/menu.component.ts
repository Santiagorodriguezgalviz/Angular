import { Component } from '@angular/core';
import { SvgComponent } from "../svg/svg.component";

@Component({
  selector: 'app-menu',
  standalone: true,
  imports: [SvgComponent],
  templateUrl: './menu.component.html',
  styleUrl: './menu.component.css'
})
export class MenuComponent {

}
