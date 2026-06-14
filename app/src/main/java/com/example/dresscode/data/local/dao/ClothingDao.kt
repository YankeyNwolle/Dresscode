package com.example.dresscode.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.example.dresscode.data.local.entity.ClothingAiAnalysisEntity
import com.example.dresscode.data.local.entity.ClothingAiCorrectionEntity
import com.example.dresscode.data.local.entity.ClothingImageEntity
import com.example.dresscode.data.local.entity.ClothingItemEntity
import com.example.dresscode.data.local.entity.ClothingOccasionCrossRefEntity
import com.example.dresscode.data.local.entity.ClothingSeasonCrossRefEntity
import com.example.dresscode.data.local.entity.ClothingStatusHistoryEntity
import com.example.dresscode.data.local.entity.ClothingStyleCrossRefEntity
import com.example.dresscode.data.local.entity.ClothingTagEntity
import com.example.dresscode.data.local.model.ClothingWithDetails
import kotlinx.coroutines.flow.Flow

@Dao
interface ClothingDao {
    @Upsert
    suspend fun upsertClothing(item: ClothingItemEntity)

    @Upsert
    suspend fun upsertClothingItems(items: List<ClothingItemEntity>)

    @Upsert
    suspend fun upsertImages(images: List<ClothingImageEntity>)

    @Upsert
    suspend fun upsertTags(tags: List<ClothingTagEntity>)

    @Upsert
    suspend fun upsertStyles(styles: List<ClothingStyleCrossRefEntity>)

    @Upsert
    suspend fun upsertSeasons(seasons: List<ClothingSeasonCrossRefEntity>)

    @Upsert
    suspend fun upsertOccasions(occasions: List<ClothingOccasionCrossRefEntity>)

    @Upsert
    suspend fun upsertAiAnalysis(analysis: ClothingAiAnalysisEntity)

    @Upsert
    suspend fun upsertAiCorrection(correction: ClothingAiCorrectionEntity)

    @Upsert
    suspend fun upsertStatusHistory(history: ClothingStatusHistoryEntity)

    @Transaction
    @Query("SELECT * FROM clothing_items WHERE id = :clothingId")
    fun observeClothingDetails(clothingId: String): Flow<ClothingWithDetails?>

    @Transaction
    @Query(
        """
        SELECT * FROM clothing_items
        WHERE user_id = :userId
        AND is_archived = 0
        AND deleted_at IS NULL
        ORDER BY updated_at DESC
        """
    )
    fun observeActiveClothes(userId: String): Flow<List<ClothingWithDetails>>

    @Query(
        """
        SELECT * FROM clothing_items
        WHERE user_id = :userId
        AND availability_status = :status
        AND is_archived = 0
        AND deleted_at IS NULL
        ORDER BY updated_at DESC
        """
    )
    fun observeClothesByStatus(userId: String, status: String): Flow<List<ClothingItemEntity>>

    @Query(
        """
        UPDATE clothing_items
        SET availability_status = :newStatus, updated_at = :updatedAt
        WHERE id = :clothingId
        """
    )
    suspend fun updateAvailabilityStatus(clothingId: String, newStatus: String, updatedAt: Long)

    @Query(
        """
        UPDATE clothing_items
        SET is_archived = 1, availability_status = 'archived', updated_at = :updatedAt
        WHERE id = :clothingId
        """
    )
    suspend fun archiveClothing(clothingId: String, updatedAt: Long)

    @Query("DELETE FROM clothing_tags WHERE clothing_item_id = :clothingId")
    suspend fun deleteTagsForClothing(clothingId: String)
}

