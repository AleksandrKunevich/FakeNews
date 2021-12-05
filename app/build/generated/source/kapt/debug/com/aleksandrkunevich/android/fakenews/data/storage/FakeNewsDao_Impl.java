package com.aleksandrkunevich.android.fakenews.data.storage;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class FakeNewsDao_Impl implements FakeNewsDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<FakeNewsEntity> __insertionAdapterOfFakeNewsEntity;

  private final EntityDeletionOrUpdateAdapter<FakeNewsEntity> __deletionAdapterOfFakeNewsEntity;

  public FakeNewsDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfFakeNewsEntity = new EntityInsertionAdapter<FakeNewsEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `fakeNews` (`title`,`author`,`date`,`topic`,`text`,`id`) VALUES (?,?,?,?,?,nullif(?, 0))";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, FakeNewsEntity value) {
        if (value.getTitle() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTitle());
        }
        if (value.getAuthor() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getAuthor());
        }
        if (value.getDate() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDate());
        }
        if (value.getTopic() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTopic());
        }
        if (value.getText() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getText());
        }
        stmt.bindLong(6, value.getId());
      }
    };
    this.__deletionAdapterOfFakeNewsEntity = new EntityDeletionOrUpdateAdapter<FakeNewsEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `fakeNews` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, FakeNewsEntity value) {
        stmt.bindLong(1, value.getId());
      }
    };
  }

  @Override
  public void insetFakeNews(final FakeNewsEntity fakeNews) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfFakeNewsEntity.insert(fakeNews);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteFakeNews(final FakeNewsEntity fakeNews) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfFakeNewsEntity.handle(fakeNews);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<FakeNewsEntity> getAll() {
    final String _sql = "SELECT * FROM fakeNews";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfAuthor = CursorUtil.getColumnIndexOrThrow(_cursor, "author");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final int _cursorIndexOfTopic = CursorUtil.getColumnIndexOrThrow(_cursor, "topic");
      final int _cursorIndexOfText = CursorUtil.getColumnIndexOrThrow(_cursor, "text");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final List<FakeNewsEntity> _result = new ArrayList<FakeNewsEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final FakeNewsEntity _item;
        final String _tmpTitle;
        if (_cursor.isNull(_cursorIndexOfTitle)) {
          _tmpTitle = null;
        } else {
          _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        }
        final String _tmpAuthor;
        if (_cursor.isNull(_cursorIndexOfAuthor)) {
          _tmpAuthor = null;
        } else {
          _tmpAuthor = _cursor.getString(_cursorIndexOfAuthor);
        }
        final String _tmpDate;
        if (_cursor.isNull(_cursorIndexOfDate)) {
          _tmpDate = null;
        } else {
          _tmpDate = _cursor.getString(_cursorIndexOfDate);
        }
        final String _tmpTopic;
        if (_cursor.isNull(_cursorIndexOfTopic)) {
          _tmpTopic = null;
        } else {
          _tmpTopic = _cursor.getString(_cursorIndexOfTopic);
        }
        final String _tmpText;
        if (_cursor.isNull(_cursorIndexOfText)) {
          _tmpText = null;
        } else {
          _tmpText = _cursor.getString(_cursorIndexOfText);
        }
        _item = new FakeNewsEntity(_tmpTitle,_tmpAuthor,_tmpDate,_tmpTopic,_tmpText);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
