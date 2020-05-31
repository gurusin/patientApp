import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'patientAdminFilter'
})
export class PatientAdminFilterPipe implements PipeTransform {

  transform(value: any, args?: any): any {
    if (args.length ===1 || args.length==0)
    {
      return value;
    }
    let filter:string = args;
    filter = filter.toUpperCase();
    return value.filter(data=>
      data.name.toUpperCase().indexOf(filter) !== -1 ||
      filter.length ===0
    );
  }


}
