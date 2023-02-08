package de.orome.tourenapplication.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import de.orome.tourenapplication.utils.Constants.TOUREN_TABLE
import kotlinx.android.parcel.Parcelize

@Entity(tableName = TOUREN_TABLE)
@Parcelize
data class Tour (

    @PrimaryKey
    @ColumnInfo(name = "tr_tour_nummer")
    val tourNummer: Int,

    @ColumnInfo(name = "tr_tour_datum")
    val tourDatum: Long = System.currentTimeMillis(),

    @ColumnInfo(name = "tr_driver_number")
    val tourDriverNumber: String,

    @ColumnInfo(name = "tr_dauer")
    val tourDauer: Long= 0L,

    @ColumnInfo(name = "tr_start_zeit")
    val tourStartZeit: Long = 0L,

    @ColumnInfo(name = "tr_ende_zeit")
    val tourEndeZeit: Long = 0L,

    @ColumnInfo(name = "tr_start_km")
    val tourStartKm: Int = 0,

    @ColumnInfo(name = "tr_ende_km")
    val tourEndeKm: Int = 0,

    @ColumnInfo(name = "tr_start_lager")
    val tourStartLager: Int = 0,

    @ColumnInfo(name = "tr_ende_lager")
    val tourEndeLager: Int = 0,

    @ColumnInfo(name = "tr_status")
    val tourStatus: Boolean = false,

    @ColumnInfo(name = "tr_vorgeladen")
    val tourVorgeladen: Boolean = false,

    @ColumnInfo(name = "tr_entsorgen")
    val tourEntsorgen: Boolean = false,

    @ColumnInfo(name = "tr_fz_reinigung")
    val tourFahrzeugReinigung: Boolean = true,

    @ColumnInfo(name = "tr_tanken")
    val tourTanken: Boolean = false,

    @ColumnInfo(name = "tr_bemerkung")
    val tourBemerkung: String = "",

    @ColumnInfo(name = "tr_depotzeit_vt")
    val tourDepotZeitVT: Long,

    @ColumnInfo(name = "tr_depotzeit_nt")
    val tourDepotZeitNT: Long,

    @ColumnInfo(name = "tr_fahrzeit")
    val tourFahrtZeit: Long,

    @ColumnInfo(name = "tr_standzeit")
    val tourStandZeit: Long,

    @ColumnInfo(name = "tr_fahrzeug_nummer")
    val tourFahrzeugNummer: Int = 0

): Parcelable
