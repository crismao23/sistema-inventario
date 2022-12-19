package com.misiontic.fruver.mapper;

    public interface IMapper<I, O>{
        public O map(I in);
}