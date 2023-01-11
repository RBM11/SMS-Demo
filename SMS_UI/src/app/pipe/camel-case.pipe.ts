import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'camelCase'
})
export class CamelCasePipe implements PipeTransform {

  transform(value: string, ...args: unknown[]): string {
    let val = value.trim().replace(' ','');
    if(val.length>1){
      return val.charAt(0).toLowerCase() + val.slice(1);
    }else{
      return val.toLocaleLowerCase();
    }
  }

}
