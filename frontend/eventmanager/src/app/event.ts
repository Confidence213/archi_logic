export class Event {

    constructor(
        public id: number,
        public title: string,
        public description: string,
        public place: string,
        public date: Date,
        public price: number
        ) { }

}