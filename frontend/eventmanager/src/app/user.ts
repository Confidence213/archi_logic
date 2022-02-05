export class User {

    constructor(
        public username: string,
        public firstname?: string,
        public lastname?: string,
        public dateOfBirth?: Date,
        public email?: string,
        public password?: string
        ) { }

}