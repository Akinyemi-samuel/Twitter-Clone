import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from '../components/home/home.component';
import { ExploreComponent } from '../components/explore/explore.component';

const routes: Routes = [
  {path:'', component:HomeComponent},
  {path:'explore', component:ExploreComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ChildRoutingModule { }
