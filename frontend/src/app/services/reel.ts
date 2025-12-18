import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReelService { // <--- ¡ASEGÚRATE DE QUE TENGA 'export'!
  private apiUrl = 'http://localhost:8080/api/reels';

  constructor(private http: HttpClient) {}

  getReels(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }
}
