import { deal } from './deal';
import { Product } from './product';
export class Seller {
     emailId: string;
     name: string;
     password: string;
     newPassword: string;
     phoneNumber: string;
     address: string;
     products: Product[];
     deals:deal[];
     errorMessage: string;
}