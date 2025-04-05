package com.dicoding.asclepius.view.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.asclepius.R
import com.dicoding.asclepius.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageUrl = Uri.parse(intent.getStringExtra(EXTRA_IMAGE_URI))
        imageUrl?.let {
            binding.resultImage.setImageURI(it)
        } ?: showToast(getString(R.string.error_load_image))

        // TODO: Menampilkan hasil gambar, prediksi, dan confidence score.
        val labelDescription = intent.getStringExtra(EXTRA_LABEL_RESULT)
        val scoreDescription =
            intent.getStringExtra(EXTRA_SCORE_RESULT)?.toDouble()?.times(100)?.toInt()
        binding.resultText.text = String.format("%s %d%%", labelDescription,
            scoreDescription)

        binding.textNews.setOnClickListener {
            goToNews()
        }

        binding.saveButton.setOnClickListener {
            showToast("This feature will develop soon")
        }
    }

    private fun goToNews() {
        val intent = Intent(this@ResultActivity, NewsActivity::class.java)
        startActivity(intent)
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val EXTRA_IMAGE_URI = "extra_image_uri"
        const val EXTRA_LABEL_RESULT = "extra_label_result"
        const val EXTRA_SCORE_RESULT = "extra_score_result"
    }


}