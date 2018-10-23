import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule, MatSelectModule, MatOptionModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { RoomComponent } from './room/room.component';
import { HotelComponent } from './hotel/hotel.component';
import { RoomstatusComponent } from './roomstatus/roomstatus.component';
import { MatStepperModule, MatIconModule } from '@angular/material';
import { ReactiveFormsModule} from '@angular/forms';
import { MatDatepickerModule} from '@angular/material/datepicker';
import { MatNativeDateModule} from '@angular/material';
import { MatTableModule} from '@angular/material'
import { MatPaginatorModule} from '@angular/material';
import { HotelService } from './shared/hotel.service';
import { LoginComponent } from './login/login.component';
import { LoginCustomerComponent } from './login-customer/login-customer.component';
const appRoutes: Routes = [
  {path: '', redirectTo: '/room' , pathMatch: 'full'},
  {path: 'hotel', component: HotelComponent},
  {path: 'room/:inputUserName', component: RoomComponent},
  {path: 'roomstatus/:inputUserName', component: RoomstatusComponent},
  {path: 'login', component: LoginComponent},
  {path: 'loginCustomer', component: LoginCustomerComponent}

];

@NgModule({
  declarations: [
    AppComponent,
    RoomComponent,
    HotelComponent,
    RoomstatusComponent,
    LoginComponent,
    LoginCustomerComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule,
    MatSelectModule,
    MatOptionModule,
    FormsModule,
    MatIconModule,
    MatStepperModule,
    ReactiveFormsModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatTableModule,
    MatPaginatorModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [HotelService],
  bootstrap: [AppComponent]
})
export class AppModule { }
