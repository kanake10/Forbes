package com.example.data.mappers

import com.example.cache.entity.*
import com.example.data.dtos.*

internal fun AllForbesDto.toEntity():AllForbesEntity{
    return AllForbesEntity(
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

internal fun FemaleDto.toEntity():FemalesEntity{
    return FemalesEntity(
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

internal fun IndustryDto.toEntity():AccordingToIndustryEntity{
    return AccordingToIndustryEntity(
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

internal fun MalesDto.toEntity():MalesEntity{
    return MalesEntity(
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

internal fun OldestDto.toEntity():OldestEntity{
    return OldestEntity(
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

internal fun YoungestDto.toEntity():YoungestEntity{
    return YoungestEntity(
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