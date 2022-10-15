package com.example.data.mappers

import com.example.cache.entity.*
import com.example.data.dtos.AllForbesDto
import com.example.data.dtos.FemaleDto
import com.example.data.dtos.MalesDto
import com.example.domain.models.*

internal fun AccordingToIndustryEntity.toDomain(): Industry{
    return Industry(
        this.rank,
        this.personName,
        this.city,
        this.source,
        this.industries,
        this.squareImage,
        this.countryOfCitizenship,
        this.bios,
        this.abouts
    )
}

internal fun AllForbesEntity.toDomain(): AllForbes{
    return AllForbes(
        this.rank,
        this.personName,
        this.city,
        this.source,
        this.industries,
        this.squareImage,
        this.countryOfCitizenship,
        this.bios,
        this.abouts
    )
}


internal fun FemalesEntity.toDomain(): Female{
    return Female(
        this.rank,
        this.personName,
        this.city,
        this.source,
        this.industries,
        this.squareImage,
        this.countryOfCitizenship,
        this.bios,
        this.abouts
    )
}

internal fun MalesEntity.toDomain(): Males{
    return Males(
        this.rank,
        this.personName,
        this.city,
        this.source,
        this.industries,
        this.squareImage,
        this.countryOfCitizenship,
        this.bios,
        this.abouts
    )
}

internal fun OldestEntity.toDomain(): Oldest{
    return Oldest(
        this.rank,
        this.personName,
        this.city,
        this.source,
        this.industries,
        this.squareImage,
        this.countryOfCitizenship,
        this.bios,
        this.abouts
    )
}

internal fun YoungestEntity.toDomain(): Youngest{
    return Youngest(
        this.rank,
        this.personName,
        this.city,
        this.source,
        this.industries,
        this.squareImage,
        this.countryOfCitizenship,
        this.bios,
        this.abouts
    )
}