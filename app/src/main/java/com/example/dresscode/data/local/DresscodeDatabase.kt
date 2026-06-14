package com.example.dresscode.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.dresscode.data.local.dao.AiDao
import com.example.dresscode.data.local.dao.ClothingDao
import com.example.dresscode.data.local.dao.NotificationDao
import com.example.dresscode.data.local.dao.OutfitDao
import com.example.dresscode.data.local.dao.ReferenceDao
import com.example.dresscode.data.local.dao.StatsDao
import com.example.dresscode.data.local.dao.SyncDao
import com.example.dresscode.data.local.dao.UserDao
import com.example.dresscode.data.local.dao.WardrobeDao
import com.example.dresscode.data.local.entity.AiFeedbackEntity
import com.example.dresscode.data.local.entity.AiRecommendationEntity
import com.example.dresscode.data.local.entity.AiRecommendationItemEntity
import com.example.dresscode.data.local.entity.CategoryEntity
import com.example.dresscode.data.local.entity.ClothingAiAnalysisEntity
import com.example.dresscode.data.local.entity.ClothingAiCorrectionEntity
import com.example.dresscode.data.local.entity.ClothingImageEntity
import com.example.dresscode.data.local.entity.ClothingItemEntity
import com.example.dresscode.data.local.entity.ClothingOccasionCrossRefEntity
import com.example.dresscode.data.local.entity.ClothingSeasonCrossRefEntity
import com.example.dresscode.data.local.entity.ClothingStatusHistoryEntity
import com.example.dresscode.data.local.entity.ClothingStyleCrossRefEntity
import com.example.dresscode.data.local.entity.ClothingTagEntity
import com.example.dresscode.data.local.entity.ColorEntity
import com.example.dresscode.data.local.entity.DailyRecommendationBatchEntity
import com.example.dresscode.data.local.entity.NotificationEntity
import com.example.dresscode.data.local.entity.OccasionEntity
import com.example.dresscode.data.local.entity.OutfitCalendarEntity
import com.example.dresscode.data.local.entity.OutfitEntity
import com.example.dresscode.data.local.entity.OutfitItemEntity
import com.example.dresscode.data.local.entity.OutfitWearHistoryEntity
import com.example.dresscode.data.local.entity.PendingSyncActionEntity
import com.example.dresscode.data.local.entity.SeasonEntity
import com.example.dresscode.data.local.entity.StyleEntity
import com.example.dresscode.data.local.entity.SubcategoryEntity
import com.example.dresscode.data.local.entity.UserEntity
import com.example.dresscode.data.local.entity.UserProfileEntity
import com.example.dresscode.data.local.entity.UserWardrobeStatsEntity
import com.example.dresscode.data.local.entity.WardrobeEntity
import com.example.dresscode.data.local.entity.WeatherSnapshotEntity

@Database(
    entities = [
        UserEntity::class,
        UserProfileEntity::class,
        WardrobeEntity::class,
        CategoryEntity::class,
        SubcategoryEntity::class,
        ColorEntity::class,
        StyleEntity::class,
        SeasonEntity::class,
        OccasionEntity::class,
        ClothingItemEntity::class,
        ClothingImageEntity::class,
        ClothingAiAnalysisEntity::class,
        ClothingAiCorrectionEntity::class,
        ClothingStatusHistoryEntity::class,
        ClothingStyleCrossRefEntity::class,
        ClothingSeasonCrossRefEntity::class,
        ClothingOccasionCrossRefEntity::class,
        ClothingTagEntity::class,
        OutfitEntity::class,
        OutfitItemEntity::class,
        OutfitWearHistoryEntity::class,
        OutfitCalendarEntity::class,
        WeatherSnapshotEntity::class,
        DailyRecommendationBatchEntity::class,
        AiRecommendationEntity::class,
        AiRecommendationItemEntity::class,
        AiFeedbackEntity::class,
        NotificationEntity::class,
        UserWardrobeStatsEntity::class,
        PendingSyncActionEntity::class
    ],
    version = 1,
    exportSchema = true
)
abstract class DresscodeDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun wardrobeDao(): WardrobeDao
    abstract fun referenceDao(): ReferenceDao
    abstract fun clothingDao(): ClothingDao
    abstract fun outfitDao(): OutfitDao
    abstract fun aiDao(): AiDao
    abstract fun notificationDao(): NotificationDao
    abstract fun statsDao(): StatsDao
    abstract fun syncDao(): SyncDao

    companion object {
        const val DATABASE_NAME = "dresscode.db"

        fun create(context: Context): DresscodeDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                DresscodeDatabase::class.java,
                DATABASE_NAME
            ).build()
        }
    }
}

