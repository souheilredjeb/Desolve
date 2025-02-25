import { bootstrapApplication } from '@angular/platform-browser';
import { AppComponent } from './app/app.component';
import { provideHttpClient } from '@angular/common/http'; // ✅ Import HttpClient provider

bootstrapApplication(AppComponent, {
  providers: [provideHttpClient()], // ✅ Provide HttpClient globally
}).catch((err) => console.error(err));
