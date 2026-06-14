package com.example.dresscode.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "notifications",
    foreignKeys = [
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = ["id"],
            childColumns = ["user_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index("user_id"),
        Index("status"),
        Index("scheduled_at")
    ]
)
data class NotificationEntity(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "user_id") val userId: String,
    val type: String,
    val title: String,
    val message: String,
    @ColumnInfo(name = "related_entity_type") val relatedEntityType: String?,
    @ColumnInfo(name = "related_entity_id") val relatedEntityId: String?,
    @ColumnInfo(name = "scheduled_at") val scheduledAt: Long?,
    @ColumnInfo(name = "sent_at") val sentAt: Long?,
    @ColumnInfo(name = "read_at") val readAt: Long?,
    val status: String
)

@Entity(
    tableName = "user_wardrobe_stats",
    foreignKeys = [
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = ["id"],
            childColumns = ["user_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["user_id"], unique = true)]
)
data class UserWardrobeStatsEntity(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "user_id") val userId: String,
    @ColumnInfo(name = "total_clothes") val totalClothes: Int,
    @ColumnInfo(name = "clean_count") val cleanCount: Int,
    @ColumnInfo(name = "worn_count") val wornCount: Int,
    @ColumnInfo(name = "dirty_count") val dirtyCount: Int,
    @ColumnInfo(name = "laundry_count") val laundryCount: Int,
    @ColumnInfo(name = "drying_count") val dryingCount: Int,
    @ColumnInfo(name = "ironing_count") val ironingCount: Int,
    @ColumnInfo(name = "pressing_count") val pressingCount: Int,
    @ColumnInfo(name = "favorite_outfits_count") val favoriteOutfitsCount: Int,
    @ColumnInfo(name = "most_used_style_id") val mostUsedStyleId: String?,
    @ColumnInfo(name = "updated_at") val updatedAt: Long
)

