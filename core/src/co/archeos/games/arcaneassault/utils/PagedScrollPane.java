package co.archeos.games.arcaneassault.utils;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;

/**
 * Created by Ajay on 2015-07-03.
 */
public class PagedScrollPane extends ScrollPane {
    private boolean mIsPanDragFling = false;

    private float mPageSpacing;

    private Table mContentTable;

    public PagedScrollPane() {
        super(null);
        initialize();
    }

    public PagedScrollPane(Actor actor) {
        super(null);
        initialize();
    }

    public PagedScrollPane(Actor widget, Skin skin) {
        super(widget, skin);
        initialize();
    }

    public PagedScrollPane(Actor widget, Skin skin, String styleName) {
        super(widget, skin, styleName);
        initialize();
    }

    public PagedScrollPane(Actor widget, ScrollPaneStyle style) {
        super(widget, style);
        initialize();
    }

    public void initialize() {
        mContentTable = new Table();
        mContentTable.defaults().space(50);
        super.setWidget(mContentTable);
    }

    public void addPage(Actor page) {
        mContentTable.add(page).expandY().fillY();
    }

    public void addPages(Actor... pages) {
        for (Actor page : pages) {
            mContentTable.add(page).expandY().fillY();
        }
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        if (mIsPanDragFling && !isPanning() && !isDragging() && !isFlinging()) {
            mIsPanDragFling = false;
            scrollToPage();
        } else {
            if (isPanning() || isDragging() || isFlinging()) {
                mIsPanDragFling = true;
            }
        }
    }

//    @Override
//    public void setWidget(Actor widget) {
//        throw new UnsupportedOperationException("Use PagedScrollPane#addPage.");
//    }

    @Override
    public void setWidth(float width) {
        super.setWidth(width);

        if (mContentTable != null) {
            for (Cell cell : mContentTable.getCells()) {
                cell.width(width);
            }

            mContentTable.invalidate();
        }
    }

    public void setPageSpacing(float pageSpacing) {
        mPageSpacing = pageSpacing;

        if (mContentTable != null) {
            mContentTable.defaults().space(pageSpacing);
            for (Cell cell : mContentTable.getCells()) {
                cell.space(pageSpacing);
            }

            mContentTable.invalidate();
        }
    }

    private void scrollToPage() {
        final float width = getWidth();
        final float scrollX = getScrollX();
        final float maxX = getMaxX();

        if (scrollX >= maxX || scrollX <= 0) {
            return;
        }

        Array<Actor> pageList = mContentTable.getChildren();
        float pageX = 0;
        float pageWidth = 0;

        if (pageList.size > 0) {
            for (Actor page : pageList) {
                pageX = page.getX();
                pageWidth = page.getWidth();
                if (scrollX < (pageX + pageWidth * 0.5)) {
                    break;
                }
            }

            setScrollX(MathUtils.clamp(pageX - (width - pageWidth) / 2, 0, maxX));
        }
    }
}
